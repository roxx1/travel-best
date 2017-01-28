import { Route } from './route.model';

export class Trip {

  constructor(
    public id: number=0,
    public price: number=0.0,
    public route: Route=new Route(),
    public minAmountOfTourists: number=10,
    public amountOfTourists: number=0,
    public expirationDate: Date=new Date(),
    public tripStartDate: Date=new Date(),
    public tripEndDate: Date=new Date()
  ) {}

}