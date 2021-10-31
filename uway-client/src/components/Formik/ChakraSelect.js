import React from "react";
import { Field } from "formik";
import {
  Select,
  FormControl,
  FormLabel,
  FormErrorMessage,
} from "@chakra-ui/react";

const ChakraSelect = ({ label, name, options,  ...rest }) => {
  return (
    <Field name={name} >
      {({ field, form }) => (
        <FormControl isInvalid={form.errors[name] && form.touched[name]}>
          <FormLabel  htmlFor={name}>{label}</FormLabel>
          <Select id={name} {...rest} {...field} >
            {options.map((option) => {
              return (
                <option key={option.code} value={option.code}>
                  {option.label}
                </option>
              );
            })}
          </Select>
          <FormErrorMessage>{form.errors[name]}</FormErrorMessage>
        </FormControl>
      )}
    </Field>
  );
};

export default ChakraSelect;
