import { isNull } from '@angular/compiler/src/output/output_ast';
import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ProductService } from './product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ProductDashboard';

  productDetails:any = null;

  productToUpdate={
    id:"",
    name:"",
    gender:"",
    brand:"",
    category:"",
    quantity:"",
    price:""
  };

  constructor(private productService: ProductService) {
    this.getProductsDetails();
  }
  addProduct(registerForm: NgForm) {
    this.productService.addProduct(registerForm.value).subscribe(
      (resp) => {
        console.log(resp);
        registerForm.reset();
        this.getProductsDetails();
      },
      (err) => {
        console.log(err);
      }
    );
  }
  getProductsDetails() {
    this.productService.getProducts().subscribe(
      (resp) => {
      console.log(resp);
      this.productDetails =resp;
      
      },
      (err) => {
        console.log(err);
      }
    );
  }
  deleteProduct(product:any){
  this.productService.deleteProduct(product.id).subscribe(
    (resp:any)=>{
      console.log(resp);
      this.getProductsDetails();
    },
    (err:any)=>
    {
      console.log(err);
    } 
  );
}
edit(product:any){
  this.productToUpdate=product;
}

updateProduct(){
  this.productService.updateProduct(this.productToUpdate).subscribe(
    (resp)=>{
      console.log(resp);
    },
    (err)=>{
      console.log(err);
    }
  )
}

}
