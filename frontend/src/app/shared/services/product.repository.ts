import {Injectable} from "@angular/core";
import {Product} from "../model/product.model";
import "rxjs/add/operator/filter";
import {RestDatasource} from "./rest.datasource";

@Injectable()
export class ProductRepository {
  private products: Product[] = [];
  private categories: string[] = [];

  constructor(private dataSource: RestDatasource) {

    dataSource.getProducts().subscribe((products: Product[]) => {
      this.products = products;
      this.categories = this.products.map(p => p.category)
        .filter((c, index, array) => array.indexOf(c) == index).sort();
    });
  }

  getProducts(category: string = null): Product[] {
    return this.products
      .filter(p => category == null || category == p.category);
  }

  getProduct(id: number): Product {
    return this.products.find(p => p.id == id);
  }

  getCategories(): string[] {
    return this.categories;
  }

  saveProduct(product: Product) {
    if (product.id && product.id !== null && product.id !== 0) {
      this.dataSource.updateProduct(product)
        .subscribe((product) => {
          this.products.splice(this.products.findIndex(p => p.id == product.id), 1, product);
        });

    } else {
      this.dataSource.saveProduct(product)
        .subscribe((product) => {
          this.products.push(product);
        });
    }
  }

  deleteProduct(id: number) {
    this.dataSource.deleteProduct(id).subscribe((product) => {
      this.products.splice(
        this.products.findIndex(
          (p) => p.id === product.id
        ), 1);
    })
  }
}
