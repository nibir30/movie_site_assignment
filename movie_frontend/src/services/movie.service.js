import axios from 'axios'

class MovieService {
  constructor() {
    this.url = import.meta.env.VITE_API_URL
  }

  async getMoviesByCategory() {
    const response = await axios.get(this.url + '/movies/by-category')
    var resData = response.data
    return resData
  }
}

export default new MovieService()
