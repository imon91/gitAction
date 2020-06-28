package services.responseModels.commerceModels;

import java.util.List;

public class ListOfCollectionsModel {


    private List<UserCollectionsBean> user_collections;

    public List<UserCollectionsBean> getUser_collections() {
        return user_collections;
    }

    public void setUser_collections(List<UserCollectionsBean> user_collections) {
        this.user_collections = user_collections;
    }

    public static class UserCollectionsBean {
        /**
         * id : 383170
         * name : Hello
         * image_url : null
         */

        private int id;
        private String name;
        private Object image_url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getImage_url() {
            return image_url;
        }

        public void setImage_url(Object image_url) {
            this.image_url = image_url;
        }
    }
}
