package demo;

import org.reactivestreams.Publisher;
import org.reactivestreams.tck.PublisherVerification;
import org.reactivestreams.tck.TestEnvironment;
import org.testng.SkipException;

public class NaivePublisherVerification  extends PublisherVerification<Integer> {


    public NaivePublisherVerification() {
        super(new TestEnvironment(500, true));
    }


    @Override
    public Publisher<Integer> createPublisher(long elementCount) {

        if(elementCount > 100L) {
            throw new SkipException("Large Publisher Not implemented");
        }

        return FirstPublisherDemo.createNaivePublisher(elementCount);
    }


    @Override
    public Publisher<Integer> createFailedPublisher() {
        throw new SkipException("Not implemented");
    }

}
