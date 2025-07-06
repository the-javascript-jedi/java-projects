import React from 'react'
import type { Expense } from '../model/Expense';

const ExpenseList = () => {
  const expenses:Expense[] = [
    {
      id: 1,
      name: "Water Bill",
      amount: 200.0,
      date: new Date().toDateString(),
      category: "Utilities",
      note: "Monthly water bill",
    },
    {
      id: 2,
      name: "Electricity bill",
      amount: 500.0,
      date: new Date().toDateString(),
      category: "Utilities",
      note: "Monthly water bill",
    },
    {
      id: 3,
      name: "Wifi Bill",
      amount: 700.0,
      date: new Date().toDateString(),
      category: "Utilities",
      note: "Monthly water bill",
    },
  ];
  return <div>
    <table border={1}>
      <thead>
        <tr>
          <th>Title</th>
          <th>Amount</th>
          <th>Date</th>
        </tr>
      </thead>
      <tbody>
        {
          expenses.map((expense) => (
            <tr key={expense.id}>
              <td>{expense.name}</td>
              <td>{expense.amount}</td>
              <td>{expense.date}</td>
            </tr>
          ))
        }
      </tbody>
    </table>
  </div>;
}

export default ExpenseList
