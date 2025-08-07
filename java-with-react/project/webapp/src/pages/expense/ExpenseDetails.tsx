import { useParams } from "react-router-dom";
import CurrencyUtils from "../../utils/CurrencyUtils";
import DateUtils from "../../utils/DateUtils";
import { useEffect, useState } from "react";
import { getExpenseByExpenseId } from "../../services/expense-service";
import type { Expense } from "../../model/Expense";
import useExpenseByExpenseId from "../../hooks/useExpenseByExpenseId";
import ConfirmDialog from "../../components/ConfirmDialog";

const ExpenseDetails = () => {
  const { expenseId } = useParams<{ expenseId: string }>();
  const { expense, error, isLoading } = useExpenseByExpenseId(expenseId ?? "");
  // Custom hook to fetch expense details
  const [showDialog, setShowDialog] = useState<boolean>(false);

  // const [expense, setExpense] = useState<Expense | undefined>();
  // const [error, setError] = useState<string | null>("");
  // const [isLoading, setIsLoading] = useState<boolean>(false);
  console.log("Expense ID:", expenseId);

  return (
    <div className="container mt-2">
      {isLoading && <p>Loading...</p>}
      {error && <p className="text-danger">{error}</p>}

      {/* api  */}
      <div className="mb-2">
        <div className="d-flex flex-row-reverse mb-2">
          <button className="btn btn-sm btn-danger">Delete</button>
          <button className="btn btn-sm btn-warning mx-2">Edit</button>
          <button className="btn btn-sm btn-secondary">Back</button>
        </div>
        <div className="card">
          <div className="card-body p-3">
            <table className="table table-striped table-hover table-responsive">
              <tbody>
                <tr>
                  <th>Name</th>
                  <td>{expense ? expense?.name : "N/A"}</td>
                </tr>
                <tr>
                  <th>Category</th>
                  <td>{expense ? expense?.category : "N/A"}</td>
                </tr>
                <tr>
                  <th>Amount</th>
                  <td>
                    {expense
                      ? CurrencyUtils.formatCurrency(
                          expense?.amount ?? 0,
                          "INR"
                        )
                      : "N/A"}
                  </td>
                </tr>
                <tr>
                  <th>Date</th>
                  <td>
                    {expense?.date !== undefined
                      ? DateUtils.formatDateString(expense?.date)
                      : "-No Data-"}
                  </td>
                </tr>
                <tr>
                  <th>Notes</th>
                  <td>{expense ? expense?.note : "N/A"}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      <ConfirmDialog
        title="Confirm Delete"
        message="Are you sure you want to delete this item?"
        show={showDialog}
      />
    </div>
  );
};
export default ExpenseDetails;
