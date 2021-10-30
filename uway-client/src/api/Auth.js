const baseUrl = "http://localhost:8080/api/v1";

export const signin = async (formData) => {
  try {
    const response = await fetch(`${baseUrl}/authenticate`, {
      method: "POST",
      body: JSON.stringify(formData),
      headers: {
        'Content-Type': 'application/json'
    }
    });

    return response.json();
  } catch(e) {
      console.log(e);
  }
};

export const signup = async (formData) => {
    try {
      const response = await fetch(`${baseUrl}/saveUser`, {
        method: "POST",
        body: JSON.stringify(formData),
        headers: {
            'Content-Type': 'application/json'
        }
      });
  
      return response;
    } catch(e) {
        console.log(e);
    }
  };
