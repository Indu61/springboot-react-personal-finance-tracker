import React from "react";
import { Link } from "react-router-dom";

export default function Home() {
  return (
    <>
      <div className="min-h-screen bg-[#f7f7f7]">
        {/* <div className="mx-10 text-center">
          <h1 className="text-2xl  bg-clip-text text-[#ee8c0a] font-bold">
            BudgetMate - Your budget’s best friend
          </h1>
        </div> */}
        <div className="flex flex-wrap">
          <div className="w-1/2 lg:w-1/4 p-2 ">
            <div className="text-center p-8 bg-white rounded-lg shadow-lg shadow-gray-400">
              💰 Balance: ₹1,20,500
            </div>
          </div>
          <div className="w-1/2 lg:w-1/4 p-2 ">
            <div className="text-center p-8 bg-white rounded-lg shadow-lg shadow-gray-400">
              📈 Income: ₹55,000
            </div>
          </div>
          <div className="w-1/2 lg:w-1/4 p-2 ">
            <div className="text-center p-8 bg-white rounded-lg shadow-lg shadow-gray-400">
              📉 Expenses: ₹38,200
            </div>
          </div>
          <div className="w-1/2 lg:w-1/4 p-2 ">
            <div className="text-center p-8 bg-white rounded-lg shadow-lg shadow-gray-400">
              🎯 Savings: 76%
            </div>
          </div>
        </div>
        <div className="flex flex-col lg:flex-row flex-wrap">
          <div className="w-full lg:w-1/2 p-2 ">
            <div className="text-center p-8 bg-white rounded-lg shadow-lg shadow-gray-400  ">
              Div 1
            </div>
          </div>
          <div className="w-full lg:w-1/2 p-2">
            <div className="text-center p-8 bg-white rounded-lg shadow-lg shadow-gray-400 ">
              Div 2
            </div>
          </div>
          <div className="w-full lg:w-1/2 p-2">
            <div className="text-center p-8 bg-white rounded-lg shadow-lg shadow-gray-400">
              Div 3
            </div>
          </div>
          <div className="w-full lg:w-1/2 p-2">
            <div className="text-center p-8 bg-white rounded-lg shadow-lg shadow-gray-400">
              Div 4
            </div>
          </div>
        </div>
      </div>
    </>
  );
}
