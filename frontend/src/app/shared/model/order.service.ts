import {Injectable} from "@angular/core";
import {CartService, Cart} from "./cart.service";

export class Order{
  public id: number;
  public name: string;
  public address: string;
  public city: string;
  public state: string;
  public zip: string;
  public country: string;
  public snipped: boolean = false;
  public cart: Cart;
}

@Injectable()
export class OrderService {
  private _order: Order;

  constructor(private cartService: CartService) {
    this._order = new Order();
    this._order.cart = cartService.cart;
  }

  get order(): Order {
    return this._order;
  }

  public clear() {
    this._order = null;
    this.cartService.clear();
  }
}
