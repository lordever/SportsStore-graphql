import {Injectable} from "@angular/core";
import {RequestMethod, Http, Request} from "@angular/http";
import {Product} from "../model/product.model";
import {Order} from "../model/order.service";
import {Observable} from "rxjs";
import "rxjs/add/operator/map";

const PROTOCOL = 'http';
const PORT = '8080';

@Injectable()
export class RestDatasource {
    baseUrl: string;
    authToken: string;

    constructor(private http: Http) {
        this.baseUrl = `${PROTOCOL}://${location.hostname}:${PORT}/`;
    }

    saveProduct(product: Product): Observable<Product> {
        return this.sendRequest(RequestMethod.Post, `product`, product, true);
    }

    updateProduct(product: Product): Observable<Product> {
        return this.sendRequest(RequestMethod.Put, `product/${product.id}`, product, true);
    }

    deleteProduct(id: number): Observable<Product> {
        return this.sendRequest(RequestMethod.Delete, `product/${id}`, null, true);
    }

    getOrders(): Observable<Order[]> {
        return this.sendRequest(RequestMethod.Get, "order", null, true);
    }

    deleteOrder(id: number): Observable<Order> {
        return this.sendRequest(RequestMethod.Delete, `order/${id}`, null, true);
    }

    updateOrder(order: Order): Observable<Product> {
        return this.sendRequest(RequestMethod.Put, `order/${order.id}`, order, true);
    }

    getProducts(): Observable<Product[]> {
        return this.sendRequest(RequestMethod.Get, "product");
    }

    saveOrder(order: Order) {
        return this.sendRequest(RequestMethod.Post, "order", order);
    }

    getCart() {
        return this.sendRequest(RequestMethod.Get, "cart");
    }

    authenticate(user: string, pass: string): Observable<boolean> {
      const url: string = `${PROTOCOL}://${location.hostname}:3500/`;
        return this.http.request(new Request({
            method: RequestMethod.Post,
            url: url + "login",
            body: {name: user, password: pass}
        })).map(response => {
            let r = response.json();
            this.authToken = r.success ? r.token : null;
            return r.success;
        });
    }

    private sendRequest(verb: RequestMethod, url: string, body?: Order | Product, auth: boolean = false): Observable<any> {
        let request = new Request({
            method: verb,
            url: this.baseUrl + url,
            body: body
        });
        if (auth && this.authToken !== null) {
            request.headers.set("Authorization", `Bearer<${this.authToken}>`);
        }
        return this.http.request(request).map((response) => response.json());
    }

}
