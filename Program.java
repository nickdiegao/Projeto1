import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite a quantidade de produtos: ");
		int n = sc.nextInt();
		
		List<Product> list = new ArrayList<>();
		
		for (int i=1;i<=n;i++) {
			System.out.println("Produto #"+i);
			System.out.print("Comum, usado ou importado (c/u/i)? ");
			char x = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Preço: ");
			double price = sc.nextDouble();
			if (x == 'i') {
				System.out.print("Custos adicionais: ");
				double custadd = sc.nextDouble();
				list.add(new ImportedProduct(name,price,custadd));
			}
			if (x == 'u') {
				System.out.println("Data de fabricação: ");
				Date fabr = sdf.parse(sc.next());
				list.add(new UsedProduct(name,price,fabr));
			}
			if (x == 'c') {
				list.add(new Product(name,price));
			}
		}
		
		System.out.println();
		System.out.println("TAGS DE PREÇO: ");
		
		for(Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}

}
