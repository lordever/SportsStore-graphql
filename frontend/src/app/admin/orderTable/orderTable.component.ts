import {Component} from "@angular/core";
import {OrderRepository} from "../../shared/services/order.repository";
import {OrderService, Order} from "../../shared/model/order.service";

@Component({
  moduleId: module.id,
  templateUrl: "orderTable.component.html"
})
export class OrderTableComponent {
  includeSnipped: boolean = false;

  constructor(private orderRepository: OrderRepository) {
  }

  getOrders(): Order[] {
    return this.orderRepository.getOrders().filter((order) => this.includeSnipped || !order.snipped);
  }

  markShipped(order: Order) {
    order.snipped = true;
    this.orderRepository.updateOrder(order);
  }

  delete(id: number) {
    this.orderRepository.deleteOrder(id);
  }
}

