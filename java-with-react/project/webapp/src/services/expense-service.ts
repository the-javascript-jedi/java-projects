import apiClient from "../config/api-client";
import type { Expense } from "../model/Expense";

export const getExpenses = () => {
  return apiClient.get<Expense[]>("/expenses");
};

export const getExpenseByExpenseId = (expenseId: string) => {
  return apiClient.get<Expense>(`/expenses/${expenseId}`);
};

export const deleteExpenseByExpenseId = (expenseId: string) => {
  return apiClient.delete<void>(`/expenses/${expenseId}`);
};

export const saveOrUpdateExpense = (expense: Expense) => {
  return apiClient.post<Expense>(`/expenses`, expense);
};
