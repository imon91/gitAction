package services.responseModels.commerceModels;

import java.util.List;

public class SearchSuggestionsModel {


    /**
     * results : {"suggestions":[{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shirts"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":1113}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in Men clothing Category","title":"shirts"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shirts"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":1118}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in Men shirts Category","title":"shirts"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shirts"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":38}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in Women clothing Category","title":"shirts"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shirts"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":57}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in T-shirts Category","title":"shirts"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shirts"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":1117}]},"url":"search_terms/search_for_user"},"meta":{},"type":"category","value":{"inline_label":"in Men t-shirts Category","title":"shirts"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"shirts"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"shirts"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"men t shirts"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"Men T shirts"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"t-shirts"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"T-shirts"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"men t-shirts"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"Men T-shirts"}},{"action":{"search_store":{"return_data":[{"key":"suggest_type","val":"auto_suggest"},{"key":"term","val":"men shirts"}]},"url":"search_terms/search_for_user"},"meta":{},"type":"auto_suggest","value":{"title":"Men Shirts"}}]}
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
             * action : {"search_store":{"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shirts"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":1113}]},"url":"search_terms/search_for_user"}
             * meta : {}
             * type : category
             * value : {"inline_label":"in Men clothing Category","title":"shirts"}
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
                 * search_store : {"return_data":[{"key":"suggest_type","val":"category"},{"key":"term","val":"shirts"},{"key":"sf_type","val":"cat_id"},{"key":"sf_val","val":1113}]}
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
                 * inline_label : in Men clothing Category
                 * title : shirts
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
