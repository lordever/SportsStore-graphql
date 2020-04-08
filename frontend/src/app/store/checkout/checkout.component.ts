import {Component} from '@angular/core';
import {OrderRepository} from "../../shared/services/order.repository";
import {OrderService} from "../../shared/model/order.service";
import {NgForm} from "@angular/forms";

@Component({
  moduleId: module.id,
  templateUrl: 'checkout.component.html',
  styleUrls: ['checkout.component.css']
})
export class CheckoutComponent {
  orderSent: boolean = false;
  submited: boolean = false;

  constructor(public orderRepository: OrderRepository,
              public orderService: OrderService) {
  }

  submitOrder(form: NgForm) {
    this.submited = true;
    if (form.valid) {
      this.orderRepository.saveOrder(this.orderService.order).subscribe(() => {
        this.orderService.clear();
        this.submited = false;
        this.orderSent = true;
      });
    }
  }
}
