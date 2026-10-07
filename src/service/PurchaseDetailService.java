package service;

import dao.PurchaseDetailDAO;
import model.PurchaseDetail;
import java.util.List;

public class PurchaseDetailService {

    private PurchaseDetailDAO dao;

    public PurchaseDetailService() {
        dao = new PurchaseDetailDAO();
    }

    public boolean addPurchaseDetail(PurchaseDetail detail) {
        return dao.addPurchaseDetail(detail);
    }

    public List<PurchaseDetail> getAllPurchaseDetails() {
        return dao.getAllPurchaseDetails();
    }

    public boolean updatePurchaseDetail(PurchaseDetail detail) {
        return dao.updatePurchaseDetail(detail);
    }

    public boolean deletePurchaseDetail(int detailId) {
        return dao.deletePurchaseDetail(detailId);
    }
}