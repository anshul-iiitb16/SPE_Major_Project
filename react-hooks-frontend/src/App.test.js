// import { render, screen } from '@testing-library/react';
// import App from './App';

// test('renders learn react link', () => {
//   render(<App />);
//   const linkElement = screen.getByText(/learn react/i);
//   expect(linkElement).toBeInTheDocument();
// });

import { render, screen } from '@testing-library/react';
import TestRenderer from 'react-test-renderer';
import App from './App';

it("Renders the App correctly", () => {
  const tree = TestRenderer.create(<App />).toJSON();
  expect(tree).toMatchSnapshot();
});
