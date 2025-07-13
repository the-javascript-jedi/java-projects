const DashboardStatus = () => {
  return (
    <div className="mt-2">
        <div className="text-center">
            <h5 className="mb-4">
                Total Expenses
            </h5>
            <h3>
                <span className="badge rounded-pill app-primary-bg-color">
                    500.00
                </span>
            </h3>
        </div>
        <div className="d-flex justify-content-between">
            <div>
                Welcome, jsjedi@example.com
            </div>
            <div>
                {new Date().toString()}
            </div>
        </div>
    </div>
  )
}
export default DashboardStatus
