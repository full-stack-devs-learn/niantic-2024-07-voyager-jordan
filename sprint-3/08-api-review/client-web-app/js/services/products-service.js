class ProductsService {

    baseUrl = `${config.baseUrl}/products`;

    getAllProducts()
    {
        return axios.get(this.baseUrl)
        .then(response => {
            return response.data;
        });
    }

    getProductsByCategoryId(catId)
    {
        return axios.get(this.baseUrl,
            {
                params: {
                    catId: catId
                }
            })
        .then(response => {
            return response.data;
        });
    }

}