import java.util.List;
import java.util.Set;
import java.util.HashSet;

class GottaSnatchEmAll {

    static Set<String> newCollection(List<String> cards) {
        return (new HashSet<>(cards));
    }

    static boolean addCard(String card, Set<String> collection) {
        return (collection.add(card));
    }

    static boolean canTrade(Set<String> myCollection, Set<String> theirCollection) {
        if (myCollection.isEmpty() || theirCollection.isEmpty()){
            return false;
        }
        
        Set<String> myCollectionCopy = new HashSet<>(myCollection);
        Set<String> theirCollectionCopy = new HashSet<>(theirCollection);
        myCollectionCopy.removeAll(theirCollection);
        theirCollectionCopy.removeAll(myCollection);

        if (myCollectionCopy.isEmpty() || theirCollectionCopy.isEmpty()){
            return false;
        }
        return true;
    }

    static Set<String> commonCards(List<Set<String>> collections) {
        Set<String> commonCollection = new HashSet<>(collections.get(0));

        for (int i = 1 ; i < collections.size(); i++){
            commonCollection.retainAll(collections.get(i));
        }

        return commonCollection;
    }

    static Set<String> allCards(List<Set<String>> collections) {
        Set<String> wholeCollection = new HashSet<>(collections.get(0));

        for (int i = 1 ; i < collections.size(); i++){
            wholeCollection.addAll(collections.get(i));
        }
        
        return wholeCollection;
    }
}
