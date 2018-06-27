package fr.ubordeaux.ao.productmanagement.domain.model;

public class ProductManagementException extends RuntimeException {
    private static final long serialVersionUID = 1L;

	public ProductManagementException(String msg) {
        super(msg);
    }
}