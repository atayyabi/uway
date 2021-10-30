import React from "react";
import { Field } from "formik";
import {
  Input,
  FormControl,
  FormLabel,
  FormErrorMessage,
  InputRightAddon,
  InputGroup,
} from "@chakra-ui/react";

const ChakraInputAddon = ({ label, name, addOn, ...rest }) => {
  return (
    <Field name={name}>
      {({ field, form }) => (
        <FormControl isInvalid={form.errors[name] && form.touched[name]}>
          <FormLabel htmlFor={name}>{label}</FormLabel>
          <InputGroup>
          <Input id={name} {...rest} {...field} />
          <InputRightAddon children={addOn}/>
          </InputGroup>
          <FormErrorMessage>{form.errors[name]}</FormErrorMessage>
        </FormControl>
      )}
    </Field>
  );
};

export default ChakraInputAddon;
