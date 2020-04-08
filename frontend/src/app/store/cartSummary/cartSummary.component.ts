import {Component} from '@angular/core';
import {CartService} from '../../shared/model/cart.service';

@Component({
  selector: 'cart-summary',
  moduleId: module.id,
  templateUrl: 'cartSummary.component.html'
})
export class CartSummaryComponent {
  constructor(private cart: CartService) {
  }
}
