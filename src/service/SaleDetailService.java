package service;

import dao.SaleDetailDAO;
import model.SaleDetail;
import java.util.List;

public class SaleDetailService {

    private SaleDetailDAO dao;

    public SaleDetailService() {
        dao = new SaleDetailDAO();
    }

    public boolean addSaleDetail(SaleDetail detail) {
        return dao.addSaleDetail(detail);
    }

    public List<SaleDetail> getAllSaleDetails() {
        return dao.getAllSaleDetails();
    }

    public boolean updateSaleDetail(SaleDetail detail) {
        return dao.updateSaleDetail(detail);
    }

    public boolean deleteSaleDetail(int detailId) {
        return dao.deleteSaleDetail(detailId);
    }
}