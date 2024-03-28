import { Oggetti } from "./oggetti.interface";
export interface OggettiRultato {
    products: Oggetti[],
    limit: number,
    skip: number,
    total: number
}

