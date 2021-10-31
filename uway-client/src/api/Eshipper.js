const baseUrl = "http://localhost:8080/api/v1";

export const getQuote = async (formData) => {
  try {
    const response = await fetch(`${baseUrl}/quote`, {
      method: "POST",
      body: formData,
      headers: { "Content-Type": "application/xml" },
    });

    return response.json();
  } catch (e) {
    console.log(e);
  }
};

export const charge = async (formData) => {
  try {
    const response = await fetch(`${baseUrl}/authenticated/payment/charge`, {
      method: "POST",
      body: formData,
      headers: { 
        "Content-Type": "application/xml",
        "Authorization": `Bearer ${JSON.parse(localStorage.getItem('token'))}` 
      },
    });

    return response.json();
  } catch (e) {
    console.log(e);
  }
};
