import { useEffect, useState } from "react";
import type { Expense } from "../model/Expense";
import { getExpenseByExpenseId } from "../services/expense-service";

const useExpenseByExpenseId = (expenseId: string) => {
  const [expense, setExpense] = useState<Expense | undefined>();
  const [error, setError] = useState<string | null>("");
  const [isLoading, setIsLoading] = useState<boolean>(false);
  useEffect(() => {
    if (expenseId !== undefined) {
      setIsLoading(true); // Set loading state to true
      setError(null); // Reset error state
      console.log("expenseId", expenseId);
      getExpenseByExpenseId(expenseId)
        .then((response) => {
          setExpense(response.data);
        })
        .catch((error) => {
          console.error("Error fetching expense details:", error);
          setError(error.message || "Failed to fetch expense details");
        })
        .finally(() => {
          setIsLoading(false);
        });
    }
  }, []);
  return { expense, error, isLoading };
};
export default useExpenseByExpenseId;
