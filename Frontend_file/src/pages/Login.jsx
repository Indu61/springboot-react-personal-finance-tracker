import React, { useContext, useRef, useState } from "react";
import AuthContext from "../context/AuthContext";
import "react-toastify/dist/ReactToastify.css";
import "../styles/style.css";
import { Link, useNavigate } from "react-router-dom";
import { Icon } from "react-icons-kit";
import { eyeOff } from "react-icons-kit/feather/eyeOff";
import { eye } from "react-icons-kit/feather/eye";
import { FaEraser } from "react-icons/fa";

export default function Login() {
  const { login } = useContext(AuthContext);
  const emailRef = useRef(null);
  const passwordRef = useRef(null);
  const nav = useNavigate();

  const [errorMessage, setErrorMessage] = useState("");
  const [customLoading, setcustomLoading] = useState(false);
  const [type, setType] = useState("text");
  const [icon, setIcon] = useState(eyeOff);

  const validateEmail = (email) => {
    const regex = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
    return regex.test(email);
  };

  const validatePassword = (password) => {
    const regex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d@$!%*?&]{8,}$/;
    return regex.test(password);
  };
  console.log("Icon component:", Icon);
  console.log("eyeOff:", eyeOff);

  const handleToggle = () => {
    if (type === "password") {
      setIcon(eye);
      setType("text");
    } else {
      setIcon(eyeOff);
      setType("password");
    }
  };

  const handleFormSubmission = async (e) => {
    e.preventDefault();
    const email = emailRef.current.value.toLowerCase().trim();
    const password = passwordRef.current.value.trim();

    console.log("email: ", email);
    console.log("password: ", password);

    if (!email || !validateEmail(email)) {
      emailRef.current.focus();
      setErrorMessage("Enter a valid email");
      return;
    }
    if (!password || !validatePassword(password)) {
      passwordRef.current.focus();
      setErrorMessage("Enter a valid password");
      return;
    }
    setcustomLoading(true);
    setTimeout(async () => {
      try {
        const loginResult = await login(email, password);
        setcustomLoading(false);
        nav("/homePage");
      } catch (error) {
        setcustomLoading(false);
        setErrorMessage(
          error.response?.data.body || "An error occurred during login."
        );
      }
    }, 1000);
  };

  return (
    <React.Fragment>
      <div className="min-h-screen flex flex-col sm:flex-row bg-gray-100">
        <div
          className="w-full sm:w-1/2 h-96 sm:h-screen bg-cover bg-center"
          style={{
            backgroundImage: 'url("../../Illustration/loginundraw.png")',
          }}
        ></div>
        <div className="w-full sm:w-1/2 flex justify-center items-center bg-white">
          <div className="max-w-xl w-full mx-auto p-8">
            <div className="relative pt-12 pb-5 rounded-3xl bg-white shadow-lg sm:rounded-3xl px-2">
              <div className="mx-10 text-center">
                <div>
                  <h1 className="text-2xl  bg-clip-text text-[#ee8c0a] font-bold">
                    BudgetMate - Your budget’s best friend
                  </h1>
                  <h1 className="text-2xl font-medium text-[#ee8c0a] mt-5">
                    Welcome Back
                  </h1>
                </div>
              </div>
              <div className="divide-y divide-gray-200">
                <div className="py-8 text-base leading-6 space-y-4 text-gray-700 sm:text-lg sm:leading-7">
                  <form onSubmit={handleFormSubmission}>
                    <div className="relative ">
                      <input
                        type="text"
                        ref={emailRef}
                        onChange={(e) =>
                          (e.target.value = e.target.value.trim())
                        }
                        maxLength={40}
                        className="peer px-2 py-1 bg-transparent mt-3 h-10 w-full border-b-2 border-gray-300 text-gray-900 focus:outline-none focus:border-rose-600"
                      />
                      <label
                        htmlFor="email"
                        className="absolute font-semibold left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm"
                      >
                        Email Address
                      </label>
                    </div>

                    <div className="relative mt-6">
                      <div className="flex flex-row">
                        <input
                          type={type}
                          ref={passwordRef}
                          maxLength={40}
                          className="peer px-2 py-1 bg-transparent mt-3 h-10 w-full border-b-2 border-gray-300 text-gray-900 focus:outline-none focus:border-rose-600"
                        />
                        <span
                          className="flex justify-around items-center"
                          onClick={handleToggle}
                        >
                          {/* <Icon
                            className="absolute mr-10"
                            icon={icon}
                            size={25}
                          /> */}
                        </span>
                      </div>
                      <label
                        htmlFor="password"
                        className="absolute font-semibold left-0 -top-3.5 text-gray-600 text-sm peer-placeholder-shown:text-base peer-placeholder-shown:text-gray-440 peer-placeholder-shown:top-2 transition-all peer-focus:-top-3.5 peer-focus:text-gray-600 peer-focus:text-sm"
                      >
                        Password
                      </label>
                    </div>
                    {errorMessage && (
                      <div className="text-red-600 nb-2">
                        <FaEraser className="inline mr-1" /> {errorMessage}
                      </div>
                    )}
                    <div className="flex justify-end mt-5">
                      <p className="text-blue-600 hover:underline text-sm items-end cursor-pointer">
                        Forgot Password?
                      </p>
                    </div>

                    <div className="relative mt-4">
                      <button
                        type="submit"
                        className="customeApplicationButton w-full"
                      >
                        Login
                      </button>
                    </div>
                  </form>
                  <p>
                    Don't have an account?{" "}
                    <Link
                      to="/register"
                      className="hover:underline text-blue-600"
                    >
                      Register here
                    </Link>
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </React.Fragment>
  );
}
