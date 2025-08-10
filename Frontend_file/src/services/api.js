import axios from "axios";

const API_URL = import.meta.env.VITE_API_URL;
console.log("api url: ", API_URL);

const axiosInstances = axios.create({
  baseURL: API_URL,
  headers: {
    "Content-Type": "application/json",
  },
});

const apiRequest = async (method, url, data = {}, params = {}) => {
  try {
    const config = {
      method,
      url,
      data,
      params,
    };
    const response = await axiosInstances(config);
    return response;
  } catch (error) {
    console.error("API request Failed:", error);
    throw error;
  }
};

{
  /* -----------------------------------------Auth Controller-------------------------------------------------*/
}
// Login user

export const loginUser = async (email, password) => {
  const response = await apiRequest(
    "POST",
    import.meta.env.VITE_AUTH_LOGIN_URL,
    null,
    { email, password }
  );
  return response;
};

export const logoutUser = async (email) => {
  const response = await apiRequest(
    "POST",
    import.meta.env.VITE_AUTH_LOGOUT_URL,
    {},
    { email }
  );
  return response;
};

{
  /*-----------------------------User Controller-------------------------------------------------------------*/
}

// Register user
export const register = async (userDto) => {
  const response = await apiRequest(
    "POST",
    import.meta.env.VITE_USERS_REGISTER_URL,
    userDto
  );
  return response;
};
