export interface Expense{
    expenseId?:number
    name:string;
    amount:number;
    date:string;
    category:string;
    note:string;
}

// const expenses:Expense[] = [
  //   {
  //     id: 1,
  //     name: "Water Bill",
  //     amount: 200.0,
  //     date: new Date().toDateString(),
  //     category: "Utilities",
  //     note: "Monthly water bill",
  //   },
  //   {
  //     id: 2,
  //     name: "Electricity bill",
  //     amount: 500.0,
  //     date: new Date().toDateString(),
  //     category: "Utilities",
  //     note: "Monthly water bill",
  //   },
  //   {
  //     id: 3,
  //     name: "Wifi Bill",
  //     amount: 700.0,
  //     date: new Date().toDateString(),
  //     category: "Utilities",
  //     note: "Monthly water bill",
  //   },
  // ];