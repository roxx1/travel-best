import { Trip } from './trip.model';
import { User } from './user.model';

export class Order {

  constructor(
    public id: number=0,
    public trip: Trip=new Trip(),
    public user: User=new User(),
    public payDate: Date=new Date(),
    public paymentSystem: string=""
  ) {}

}