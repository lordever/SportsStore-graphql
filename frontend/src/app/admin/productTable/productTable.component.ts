import {Component} from "@angular/core";
import {ProductRepository} from "../../shared/services/product.repository";
import {Product} from "../../shared/model/product.model";

@Component({
  moduleId: module.id,
  templateUrl: "productTable.component.html"
})
export class ProductTableComponent{
  constructor(private repository: ProductRepository){}

  getProducts(): Product[]{
    return this.repository.getProducts();
  }

  deleteProduct(id: number){
    this.repository.deleteProduct(id);
  }
}
