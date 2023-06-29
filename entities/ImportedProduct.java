package entities;

public class ImportedProduct extends Product{
	
	private Double customFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, Double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	public double amount() {
		return getPrice() + customFee;
	}
	
	@Override
	public String priceTag() {
		return getName() + " R$"+ String.format("%.2f",amount()) + "(Custos adicionais: R$ " + customFee +")";
	}
	
	
}


