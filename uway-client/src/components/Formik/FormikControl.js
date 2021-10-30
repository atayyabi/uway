import React from 'react'
import ChakraInput from "./ChakraInput";
import ChakraSelect from "./ChakraSelect";
import ChakraInputAddon from './ChakraInputAddon';
import ChakraSwitch from "./ChakraSwitch"

const FormikControl = ({control, ...rest}) => {
    
  switch (control) {
    case 'input':
      return <ChakraInput {...rest} />
    case 'select':
      return <ChakraSelect {...rest} />
    case 'input-addon':
      return <ChakraInputAddon {...rest} />
    case 'switch':
      return <ChakraSwitch {...rest} />
    default:
      return null
  }
}

export default FormikControl
