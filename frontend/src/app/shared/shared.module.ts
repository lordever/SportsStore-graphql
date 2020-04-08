import {NgModule} from '@angular/core';
import {StaticDataSource} from './services/static.datasource';
import {ProductRepository} from './services/product.repository';
import {CartService} from './model/cart.service';
import {OrderService} from './model/order.service';
import {OrderRepository} from './services/order.repository';
import {RestDatasource} from "./services/rest.datasource";
import {HttpModule} from "@angular/http";
import {AuthService} from "./services/auth.service";

@NgModule({
  imports: [HttpModule],
  providers: [StaticDataSource, ProductRepository, CartService,
    OrderService, OrderRepository,
    {provide: StaticDataSource, useClass: RestDatasource},
    RestDatasource, AuthService
  ]
})
export class SharedModule {
}
