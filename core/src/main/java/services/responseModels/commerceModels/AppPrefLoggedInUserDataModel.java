package services.responseModels.commerceModels;

import java.util.List;

public class AppPrefLoggedInUserDataModel {


    /**
     * results : {"suggestions":[{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shoes"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":1114}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in Men footwear Category","title":"shoes"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shoes"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":1138}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in Men casual shoes Category","title":"shoes"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shoes"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":148}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in Accessories Category","title":"shoes"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shoes"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":70}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in Women cosmetics Category","title":"shoes"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shoes"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":111}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in Face Category","title":"shoes"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"men formal shoes"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"men formal shoes"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"men casual shoes"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"men casual shoes"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"baby shoe"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"baby shoe"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"shoes"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"Shoes"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"sport shoes"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"sport shoes"}}]}
     */

    private ResultsBean results;

    public ResultsBean getResults() {
        return results;
    }

    public void setResults(ResultsBean results) {
        this.results = results;
    }

    public static class ResultsBean {
        private List<SuggestionsBean> suggestions;

        public List<SuggestionsBean> getSuggestions() {
            return suggestions;
        }

        public void setSuggestions(List<SuggestionsBean> suggestions) {
            this.suggestions = suggestions;
        }

        public static class SuggestionsBean {
            /**
             * action : {"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shoes"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":1114}]},"url":"search_terms/search_for_user"}
             * meta : {}
             * type : category
             * value : {"inline_label":"in Men footwear Category","title":"shoes"}
             */

            private ActionBean action;
            private MetaBean meta;
            private String type;
            private ValueBean value;

            public ActionBean getAction() {
                return action;
            }

            public void setAction(ActionBean action) {
                this.action = action;
            }

            public MetaBean getMeta() {
                return meta;
            }

            public void setMeta(MetaBean meta) {
                this.meta = meta;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public ValueBean getValue() {
                return value;
            }

            public void setValue(ValueBean value) {
                this.value = value;
            }

            public static class ActionBean {
                /**
                 * search_store : {"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shoes"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":1114}]}
                 * url : search_terms/search_for_user
                 */

                private SearchStoreBean search_store;
                private String url;

                public SearchStoreBean getSearch_store() {
                    return search_store;
                }

                public void setSearch_store(SearchStoreBean search_store) {
                    this.search_store = search_store;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public static class SearchStoreBean {
                    private List<ReturnDataBean> return_data;

                    public List<ReturnDataBean> getReturn_data() {
                        return return_data;
                    }

                    public void setReturn_data(List<ReturnDataBean> return_data) {
                        this.return_data = return_data;
                    }

                    public static class ReturnDataBean {
                    }
                }
            }

            public static class MetaBean {
            }

            public static class ValueBean {
                /**
                 * inline_label : in Men footwear Category
                 * title : shoes
                 */

                private String inline_label;
                private String title;

                public String getInline_label() {
                    return inline_label;
                }

                public void setInline_label(String inline_label) {
                    this.inline_label = inline_label;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
