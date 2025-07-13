import type { Expense } from '../model/Expense';

interface Props{
    expenses:Expense[];
}
const ExpenseList = ({expenses}:Props) => {
  
  return <div className="card">
    <div className="card-header">
      Expense
      <span className="float-end">
        Amount
      </span>
    </div>
    {expenses.map(expense=>  <div className="card-body">
      <div key={expense.expenseId} className="card mb-3">
        <div className="d-flex justify-content-between border-bottom-1 p3 text-dark">
          <div className="card-title m-0">
            <h5>
             {expense.name}
            </h5>
            <span className="fst-italic">
      {expense.date.toString()}
            </span>
          </div>
          <div className="card-subtitle">
            <span className="badge rounded-pill app-primary-bg-color">
             {expense.amount}
            </span>
          </div>
        </div>
      </div>
    </div>)}
  </div>
  // <div>
  //   <table border={1}>
  //     <thead>
  //       <tr>
  //         <th>Title</th>
  //         <th>Amount</th>
  //         <th>Date</th>
  //       </tr>
  //     </thead>
  //     <tbody>
  //       {
  //         expenses.map((expense) => (
  //           <tr key={expense.expenseId}>
  //             <td>{expense.name}</td>
  //             <td>{expense.amount}</td>
  //             <td>{expense.date}</td>
  //           </tr>
  //         ))
  //       }
  //     </tbody>
  //   </table>
  // </div>;
}

export default ExpenseList
