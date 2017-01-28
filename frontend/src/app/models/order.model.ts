import { Trip } from './trip.model';

export class Order {

  constructor(
    public id: number=0,
    public trip: Trip=new Trip(),
    public payDate: Date=new Date(),
    public endDate: Date=new Date()
  ) {}

}