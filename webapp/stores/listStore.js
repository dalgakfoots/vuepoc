import {defineStore} from "pinia";

const getListUrl = (url , route) => {
    let tempUrl = new URL(url);
    let page = route.query.page ? route.query.page - 1 : '';
    tempUrl.searchParams.set('page' , page);
    return {
        url : tempUrl,
        proxyUrl : tempUrl.pathname + tempUrl.search
    }
}

export const useListStore = defineStore('listStore', {
    state: () => ({
        list : [],
        totalPages : 0,
        currentPage : 0,
    }),
    getters : {
        getList(state) {
            return state.list
        },

        getTotalPageNumber(state) {
            return state.totalPages;
        },

        getCurrentPageNumber(state) {
            return state.currentPage;
        }
    },

    actions : {
        async fetchListForServer(route) {
            try {
                const data = await fetch(
                    getListUrl('http://localhost:8080/api/list' , route).url
                );
                const temp = await data.json();
                this.list = temp.content;
                this.totalPages = temp.totalPages;
                this.currentPage = temp.number + 1;
            } catch (e) {
                console.log(e);
            }
        } ,
        async fetchListForClient(route) {
            try {
                const data = await fetch(
                    getListUrl('http://localhost:8080/api/list', route).proxyUrl
                );
                const temp = await data.json();
                this.list = temp.content;
                this.totalPages = temp.totalPages;
                this.currentPage = temp.number + 1;
            } catch (e) {
                console.log(e);
            }
        } ,

        async changeCurrentPageNumber(number) {
            if (+number === this.currentPage) return;
            // const data = await fetch(`/api/list?page=${number-1}`);
            // const temp = await data.json();
            // this.list = temp.content;
            // this.totalPages = temp.totalPages;
            this.currentPage = +number;
        }
    }
})