import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  API = 'http://localhost:8080';
  public addProduct(productData: any) {
    return this.http.post(this.API + '/addProduct', productData);
  }

  public getProducts() {
    return this.http.get(this.API + '/getProducts')
  }

  public deleteProduct(id: any) {
    return this.http.delete(this.API + '/deleteProduct?id=' + id);

  }

  public updateProduct(product:any){
    return this.http.put(this.API+'/updateProduct',product);

  }
}
