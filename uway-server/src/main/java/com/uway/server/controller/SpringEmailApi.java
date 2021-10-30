package com.uway.server.controller;

import com.uway.server.model.dto.EmailStatus;
import com.uway.server.model.dto.PaymentSuccessResponse;
import com.uway.server.model.dto.SupportRequest;
import com.uway.server.model.eshipper.ShippingRequestWrapper;
import com.uway.server.model.eshipper.Item;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class SpringEmailApi {

	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping(value = "/api/v1/send-support-request")
	public EmailStatus getUserSupportEmail(@RequestBody SupportRequest request) throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("ali@uway.io");
		helper.setSubject(request.getReasonType() + " " + request.getEmail());
		helper.setTo("sales@uway.io");
		helper.setText(request.getDescription());
		EmailStatus status = new EmailStatus();

		try {
			javaMailSender.send(message);
			status.setStatus("Your request has successfully been submitted");
		} catch (Exception e) {
			e.printStackTrace();

		}

		return status;
	}

	public String sendDomesticOrderConfirmationEmail(PaymentSuccessResponse paymentSuccessResponse, ShippingRequestWrapper cfw)
			throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("sales@uway.io");
		helper.setTo(cfw.getShippingRequest().getFrom().getEmail());
		helper.setSubject("Order Confirmation # " + paymentSuccessResponse.getId() + " Shipping Documents");
		helper.setText("Order # " + paymentSuccessResponse.getId()
				+ " Thank you for choosing uway. Attached are all of the documents you need to get your package on its way");
		
		FileSystemResource file = new FileSystemResource(
				new File("ShippingLabel" + paymentSuccessResponse.getId() + ".pdf"));
		helper.addAttachment("ShippingLabel" + paymentSuccessResponse.getId(), file);

		javaMailSender.send(message);

		return "Your email was submitted successfully";

	}

	public String sendOrderConfirmationEmail( PaymentSuccessResponse paymentSuccessResponse, ShippingRequestWrapper cfw)
			throws MessagingException {

		MimeMessage message = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("sales@uway.io");
		helper.setTo(cfw.getShippingRequest().getFrom().getEmail());
		helper.setSubject("Order Confirmation # " + paymentSuccessResponse.getId() + "Shipping Labels and Documents");
		helper.setText("Order #" + paymentSuccessResponse.getId()
				+ "Thank you for choosing uway. Attached are all of the documents you need to get your package on its way");
		
		FileSystemResource file1 = new FileSystemResource(
				new File("ShippingLabel" + paymentSuccessResponse.getId() + ".pdf"));
		
		helper.addAttachment("ShippingLabel" + paymentSuccessResponse.getId(), file1);
		
		if (!(cfw.getShippingRequest().getTo().getCountry().equals("CA")) && (cfw.getShippingRequest().getPackages().getType().equals("package"))) {
			FileSystemResource file2 = new FileSystemResource(
					new File("CustomsInvoice" + paymentSuccessResponse.getId() + ".pdf"));
					helper.addAttachment("CustomsInvoice" + paymentSuccessResponse.getId(), file2);
		}

		javaMailSender.send(message);

		return "Your email was submitted successfully";

	}

	@PostMapping(value = "/verifyCustomsForm")
	public String testCustomsFormPdf(PaymentSuccessResponse response, ShippingRequestWrapper cfw) throws FileNotFoundException, DocumentException {

		Document document = new Document();

		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream("CustomsInvoice" + response.getId() + ".pdf"));
		document.open();
		document.add(new Paragraph("Customs Invoice"));
		document.add(Chunk.NEWLINE);
		
		PdfPTable orderTable = new PdfPTable(2);
		orderTable.setWidthPercentage(100);
		orderTable.addCell(new Paragraph("ORDER INFORMATION"));
		orderTable.addCell(new Paragraph("TRACKING # : " + response.getTrackingNumber() + "\n" + "ORDER # : " + response.getId()));
		document.add(orderTable);
		
		
		
		PdfPTable infoTable = new PdfPTable(2);
		infoTable.setWidthPercentage(100);
		infoTable.addCell(new Paragraph("SHIP FROM"));
		infoTable.addCell(new Paragraph("SHIP TO"));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getFrom().getCompany()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getTo().getCompany()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getFrom().getAddress1()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getTo().getAddress1()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getFrom().getCity()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getTo().getCity()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getFrom().getState()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getTo().getState()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getFrom().getZip()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getTo().getZip()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getFrom().getCountry()));
		infoTable.addCell(new Paragraph(cfw.getShippingRequest().getTo().getCountry()));
		
		document.add(infoTable);
		
		document.add(Chunk.NEWLINE);
		

		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100);
		table.addCell(new Paragraph("QTY"));
		table.addCell(new Paragraph("COUNTRY OF ORIGIN"));
		table.addCell(new Paragraph("TARIFF CODE"));
		table.addCell(new Paragraph("DESCRIPTION"));
		table.addCell(new Paragraph("VALUE (CAD)"));
		
		for (Item item : cfw.getCustomsInvoice().getItem()) {
			table.addCell(new Paragraph(item.getQuantity()));
			table.addCell(new Paragraph(item.getOriginCountry()));
			table.addCell(new Paragraph(item.getCode()));
			table.addCell(new Paragraph(item.getDescription()));
			table.addCell(new Paragraph(item.getUnitPrice()));
			
		}
		
		document.add(table);
		
		int totalValue = 0;
		for (Item item : cfw.getCustomsInvoice().getItem()) {
			totalValue += Integer.parseInt(item.getUnitPrice());
		}
		PdfPTable summaryTable = new PdfPTable(2);
		summaryTable.setWidthPercentage(100);
		summaryTable.addCell(new Paragraph("TOTAL VALUE (CAD)"));
		summaryTable.addCell(new Paragraph(totalValue + " "));
		document.add(summaryTable);
		
		document.add(Chunk.NEWLINE);
		
		document.add(new Paragraph("Please send all duties and taxes requests to the receiver"));
		
		
		
		document.close();

		return "Your form has been created";

	}

	public String createOrderDocumentsPdf(PaymentSuccessResponse paymentSuccessResponse) throws IOException {

		String label = paymentSuccessResponse.getEncodedLabel();
		System.out.println(label);
		byte[] decodedLabelBytes = Base64.getDecoder().decode(label);
		System.out.println(decodedLabelBytes);
		try {
			FileOutputStream fos = new FileOutputStream(
					new File("ShippingLabel" + paymentSuccessResponse.getId() + ".pdf"));
			fos.write(decodedLabelBytes);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Your Pdf has been created";
	}

	public String createOrderDocumentsCustomsInvoice(PaymentSuccessResponse paymentSuccessResponse) throws IOException {

		String invoice = paymentSuccessResponse.getEncodedCustomsInvoice();
		byte[] decodedLabelBytes = Base64.getDecoder().decode(invoice);
		try {
			FileOutputStream fos = new FileOutputStream(
					new File("CustomsInvoice" + paymentSuccessResponse.getId() + ".pdf"));
			fos.write(decodedLabelBytes);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "Your Pdf has been created";
	}

	

}
