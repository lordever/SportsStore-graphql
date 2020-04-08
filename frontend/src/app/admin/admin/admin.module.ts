import {NgModule} from "@angular/core";
import {AuthComponent} from "../auth/auth.component";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {AdminComponent} from "./admin.component";
import {AuthGuard} from "../auth/auth.guard";
import {ProductTableComponent} from "../productTable/productTable.component";
import {ProductEditorComponent} from "../productEditor/productEditor.component";
import {OrderTableComponent} from "../orderTable/orderTable.component";

let routing = RouterModule.forChild([
  { path: "auth", component: AuthComponent },
  {
    path: "main", component: AdminComponent,
    children: [
      { path: "products/:mode/:id", component: ProductEditorComponent },
      { path: "products/:mode", component: ProductEditorComponent },
      { path: "products", component: ProductTableComponent },
      { path: "orders", component: OrderTableComponent },
      { path: "**", redirectTo: "products" }
    ]
  },
  { path: "**", redirectTo: "auth" }
]);

@NgModule({
  imports: [CommonModule, FormsModule, routing],
  providers: [AuthGuard],
  declarations: [AuthComponent, AdminComponent, ProductEditorComponent, ProductTableComponent, OrderTableComponent]
})
export class AdminModule {
}
