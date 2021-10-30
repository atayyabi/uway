import React from "react";
import { Field } from "formik";
import {
  Switch,
  FormControl,
  FormLabel,
  FormErrorMessage,
} from "@chakra-ui/react";

const ChakraSwitch = ({ label, name, isChecked, size, ...rest }) => {
  return (
    <Field name={name}>
      {({ field, form }) => (
        <FormControl isInvalid={form.errors[name] && form.touched[name]}>
          <FormLabel htmlFor={name}>{label}</FormLabel>
          <Switch id={name} name={name} {...rest} {...field} size={size}/>
          <FormErrorMessage>{form.errors[name]}</FormErrorMessage>
        </FormControl>
      )}
    </Field>
  );
};

export default ChakraSwitch;
