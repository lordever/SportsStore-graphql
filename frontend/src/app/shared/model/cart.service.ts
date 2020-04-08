import {Injectable} from '@angular/core';
import {Product} from './product.model';
import {RestDatasource} from "../services/rest.datasource";

export class Cart {
  public id: number;
  public lines: CartLine[];
  public itemCount: number;
  public cartPrice: number;
}

@Injectable()
export class CartService {
  private _cart: Cart;

  constructor(private restDataSource: RestDatasource) {
    if (!this._cart) {
      this._cart = JSON.parse(window.localStorage.getItem("cart")) as any;
    }
    if (!this._cart) {
      restDataSource.getCart().subscribe((cart: Cart) => {
        cart.lines = [];
        this.saveToLocalStorage(cart);
        this._cart = cart;
      })
    }
  }


  get cart(): Cart {
    return this._cart;
  }

  addLine(product: Product, quantity: number = 1) {
    let line = this._cart.lines && this._cart.lines.length > 0 && this._cart.lines.find(line => line.product.id == product.id);
    if (!!line) {
      line.quantity += quantity;
    } else {
      this._cart.lines.push(new CartLine(product, quantity));
    }
    this.recalculate();
  }

  updateQuantity(product: Product, quantity: number) {
    let line = this._cart.lines.find(line => line.product.id == product.id);
    if (line) {
      line.quantity = Number(quantity);
    }
    this.recalculate();
  }

  removeLine(id: number) {
    let index = this._cart.lines.findIndex(line => line.product.id == id);
    this._cart.lines.splice(index);
    this.recalculate();
  }

  clear() {
    this._cart.lines = [];
    this._cart.itemCount = 0;
    this._cart.cartPrice = 0;
    window.localStorage.removeItem("cart");
  }

  getLineCount(): number {
    return this._cart.lines ? this._cart.lines.length : 0;
  }

  private recalculate() {
    this._cart.itemCount = 0;
    this._cart.cartPrice = 0;
    if (this._cart.lines.length > 0) {
      this._cart.lines.forEach(l => {
        this._cart.itemCount += l.quantity;
        this._cart.cartPrice += (l.quantity * l.product.price);
      });
    }
    this.saveToLocalStorage(this._cart);
  }

  private saveToLocalStorage(cart: Cart) {

    window.localStorage.setItem("cart", JSON.stringify(cart));
  }
}

export class CartLine {
  constructor(public product: Product,
              public quantity: number) {
  }

  get lineTotal() {
    return this.quantity * this.product.price;
  }
}
