package model;

public class Purchase {

    private int purchaseId;
    private int supplierId;
    private int employeeId;
    private String purchaseDate;
    private double totalAmount;

    public Purchase(int purchaseId, int supplierId, int employeeId,
                    String purchaseDate, double totalAmount) {

        this.purchaseId = purchaseId;
        this.supplierId = supplierId;
        this.employeeId = employeeId;
        this.purchaseDate = purchaseDate;
        this.totalAmount = totalAmount;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}