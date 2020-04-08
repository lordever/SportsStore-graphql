import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {SharedModule} from '../shared/shared.module';
import {FormsModule} from '@angular/forms';
import {StoreComponent} from './store.component';
import {CounterDirective} from './counter/counter.directive';
import {CartSummaryComponent} from './cartSummary/cartSummary.component';
import {CartDetailComponent} from './cartDetail/cartDetail.component';
import {CheckoutComponent} from './checkout/checkout.component';
import {RouterModule} from '@angular/router';

@NgModule({
  imports: [SharedModule, BrowserModule, FormsModule, RouterModule],
  declarations: [StoreComponent, CounterDirective, CartSummaryComponent,
    CartDetailComponent, CheckoutComponent],
  exports: [StoreComponent]
})
export class StoreModule {
}
