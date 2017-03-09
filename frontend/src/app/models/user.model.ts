export class User {

  constructor(
    public id: number=0,
    public username: string="",
    public email: string="",
    public role: number=0
  ) {}

  toString() {
    return JSON.stringify(this);
  }

}
