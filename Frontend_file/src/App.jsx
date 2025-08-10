import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import "./App.css";
import Layout from "./Layout";
import Home from "./pages/HomePage";
import About from "./components/common/About";
import Contact from "./components/common/Contact";
import Login from "./pages/Login";
import Register from "./pages/Register";
import ErrorBoundary from "./components/ErrorBoundary";
import ProtectedRoute from "./components/ProtectedRoute";
import NotFound from "./components/common/NotFound";

function App() {
  return (
    <>
      <Router>
        <Routes>
          <Route path="/login" element={<Login />} />

          <Route
            path="/register"
            element={
              <ErrorBoundary>
                <Register />
              </ErrorBoundary>
            }
          />

          <Route
            path="/homePage"
            element={
              <ErrorBoundary>
                <ProtectedRoute>
                  <Layout />
                </ProtectedRoute>
              </ErrorBoundary>
            }
          >
            <Route path="" element={<Home />} />
            <Route path="about" element={<About />} />
            <Route path="contact" element={<Contact />} />
          </Route>

          <Route
            path="/notFound"
            element={
              <ErrorBoundary>
                <NotFound />
              </ErrorBoundary>
            }
          />
          <Route path="*" element={<Navigate to="/notFound" />} />
        </Routes>
      </Router>
    </>
  );
}

export default App;
