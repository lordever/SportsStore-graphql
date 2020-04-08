import {Component} from '@angular/core';
import {ProductRepository} from '../shared/services/product.repository';
import {Product} from '../shared/model/product.model';
import {CartService} from '../shared/model/cart.service';
import {Router} from '@angular/router';

@Component({
  selector: 'store',
  moduleId: module.id,
  templateUrl: 'store.component.html'
})
export class StoreComponent {
  public selectedCategory = null;
  public productPerPage = 4;
  public selectedPage = 1;

  constructor(private repository: ProductRepository, private cart: CartService, private router: Router) {
  }

  get products(): Product[] {
    let pageIndex = (this.selectedPage - 1) * this.productPerPage;
    return this.repository.getProducts(this.selectedCategory)
      .slice(pageIndex, pageIndex + this.productPerPage);
  }

  get categories(): string[] {
    return this.repository.getCategories();
  }

  changeCategory(newCategory ?: string) {
    this.selectedCategory = newCategory;
  }

  changePage(newPage: number) {
    this.selectedPage = newPage;
  }

  changePageSize(newSize: number) {
    this.productPerPage = Number(newSize);
  }

  get pageCount(): number {
    return Math.ceil(this.repository
      .getProducts(this.selectedCategory).length / this.productPerPage);
  }

  addProductToCart(product: Product) {
    this.cart.addLine(product);
    this.router.navigateByUrl("/cart");
  }
}
