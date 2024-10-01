export class Product
{
    productId!: number
    productName!: string
    unitPrice!: number
    supplierId?: number
    categoryId?: number
    description?: string
    unitsInStock?: number
    unitsOnOrder?: number
    reorderLevel?: number
    isDiscontinued?: boolean

    constructor(productId: number, productName: string, unitPrice: number)
    {
        this.productId = productId
        this.productName = productName
        this.unitPrice = unitPrice
    }
}