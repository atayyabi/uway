const baseUrl = "http://localhost:8080/api/v1/authenticated";

export const getOrders = async (formData) => {
    try {
      const response = await fetch(`${baseUrl}/getAllUserPrincipalOrder`, {
        method: "GET",
        body: formData,
        headers: { 
            "Content-Type": "application/json",
            "Authorization": `Bearer ${JSON.parse(localStorage.getItem('token'))}`,
            "Access-Control-Allow-Origin": "*"
        },
      });
  
      return response.json();
    } catch (e) {
      console.log(e);
    }
  };

