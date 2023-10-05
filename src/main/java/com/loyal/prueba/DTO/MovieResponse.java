package com.loyal.prueba.DTO;

import java.util.List;

public class MovieResponse {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<MovieData> data;

    public MovieResponse(int page, int per_page, int total, int total_pages, List<MovieData> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<MovieData> getData() {
        return data;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(List<MovieData> data) {
        this.data = data;
    }


    public static class MovieData {
        private String Title;
        private int Year;
        private String imdbID;

        public String getTitle() {
            return Title;
        }

        public int getYear() {
            return Year;
        }

        public String getImdbID() {
            return imdbID;
        }

        public void setTitle(String title) {
            this.Title = title;
        }

        public void setYear(int year) {
            this.Year = year;
        }

        public void setImdbID(String imdbID) {
            this.imdbID = imdbID;
        }

        public MovieData(String Title, int Year, String imdbID) {
            this.Title = Title;
            this.Year = Year;
            this.imdbID = imdbID;
        }

    }

    public List<MovieData> getData() {
        return data;
    }

    public void setData(List<MovieData> data) {
        this.data = data;
    }


}